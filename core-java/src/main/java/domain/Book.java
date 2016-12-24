package domain;

/**
 * Author: ddubson
 */
public class Book {
    public String name;
    public String year;

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;

        if (this == o) {
            return true;
        }

        if (!(o instanceof Book)) return false;

        Book obj = (Book) o;
        boolean equals = true;
        if (obj.name != null && !obj.name.equals(this.name)) equals = false;
        if (obj.year != null && !obj.year.equals(this.year)) equals = false;

        return equals;
    }

    @Override
    public int hashCode() {/*
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (year != null ? year.hashCode() : 0);
        return result;*/
        return 0;
    }
}