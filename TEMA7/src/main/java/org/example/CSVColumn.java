package org.example;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Custom annotation for CSV column mapping
@Retention(RetentionPolicy.RUNTIME)
@interface CSVColumn {
    int index();
}
