package com.myapp.config;

public interface JsonPropertyView {
    public interface Basic {
    }

    public interface Category extends Basic {
    }

    public interface Provider extends Basic {
    }

    public interface Customer extends Basic {
    }

    public interface Product extends Basic {
    }

    public interface All extends Basic, Category, Customer, Provider {
    }
}
