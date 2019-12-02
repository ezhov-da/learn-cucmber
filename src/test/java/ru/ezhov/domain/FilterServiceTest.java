package ru.ezhov.domain;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Но;
import io.cucumber.java.ru.Тогда;
import ru.ezhov.domain.model.FilterNumber;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FilterServiceTest {

    FilterService filterService;

    @Допустим("есть следующие фильтры")
    public void filters(DataTable dataTable) {
        List<FilterNumber> numbers = dataTable
                .cells()
                .stream()
                .map(l -> new FilterNumber(Integer.parseInt(l.get(0)), Integer.parseInt(l.get(1)))
                ).collect(Collectors.toList());

        filterService = new FilterService(numbers);
    }

    @Тогда("должен найти фильтр по {int} и {int}")
    public void долженНайтиФильтрПоИ(Integer x, Integer y) {
        assertThat(filterService.find(new FilterNumber(x, y)), is(equalTo(true)));
    }

    @Но("не должен найти фильтр по {int} и {int}")
    public void недолженНайтиФильтрПоИ(Integer x, Integer y) {
        assertThat(filterService.find(new FilterNumber(x, y)), is(equalTo(false)));
    }
}