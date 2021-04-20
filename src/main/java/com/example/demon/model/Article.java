package com.example.demon.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article implements Serializable {

  private int id;


  private String rId;
  private String rPw;

  private String rName;

}
