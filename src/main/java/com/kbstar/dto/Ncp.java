package com.kbstar.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Ncp {
    private MultipartFile img;
}