package ru.ezhov.domain.model;

public class FilterNumber {
    private int x;
    private int y;

    public FilterNumber(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public boolean equals(FilterNumber o) {
        return x == o.x &&
                y == o.y;
    }
}
