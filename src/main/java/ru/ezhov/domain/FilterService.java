package ru.ezhov.domain;

import ru.ezhov.domain.model.FilterNumber;

import java.util.List;
import java.util.Optional;

public class FilterService {

    private List<FilterNumber> filterNumbers;

    public FilterService(List<FilterNumber> filterNumbers) {
        this.filterNumbers = filterNumbers;
    }

    public boolean find(FilterNumber fn) {
        Optional<FilterNumber> filterNumberOptional =
                filterNumbers
                        .stream()
                        .filter(filterNumber -> filterNumber.equals(fn))
                        .findFirst();
        return filterNumberOptional.isPresent();
    }
}
