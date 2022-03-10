package com.jb.checkApp.advice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErrDetails {

    private String key;
    public String value;
}
