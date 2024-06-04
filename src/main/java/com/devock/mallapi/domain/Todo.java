package com.devock.mallapi.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tbl_todo")
@Getter
@ToString
// Builder 어노테이션 사용 시
// AllArgsConstructor, NoArgsConstructor 는 세트로 같이 들어간다.
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Todo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long tno;

  private String title;

  private String content;

  private String writer;

  private boolean complete;

  private LocalDate dueDate;

  public void changeTitle(String title) {
    this.title = title;
  }

  public void changeComplete(boolean complete) {
    this.complete = complete;
  }

  public void changeDueDate(LocalDate dueDate) {
    this.dueDate = dueDate;
  }

}