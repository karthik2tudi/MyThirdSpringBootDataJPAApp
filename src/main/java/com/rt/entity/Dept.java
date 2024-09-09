package com.rt.entity;

import jakarta.persistence.Entity;
import lombok.Data;

//@Entity
@Data
public class Dept {
  private int deptId;
  private String deptname;
}
