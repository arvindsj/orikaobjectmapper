package com.arvind.pojo;

public class Country {

    private String name;

    public Country() {
    }

    public Country(final String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Country)) {
            return false;
        }

        Country country = (Country) o;

        if (name != null ? !name.equals(country.name) : country.name != null) {
            return false;
        }

        return true;
    }
}
