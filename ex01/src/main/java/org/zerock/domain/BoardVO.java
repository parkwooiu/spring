package org.zerock.domain;

import java.util.Date;

import lombok.Data;
@Data
public class BoardVO {

	private Long bno; //게시물 번호
	private String title; //게시물 제목
	private String content; // 게시물 내용
	private String writer; //게시물 작성자
	private Date regdate; //게시물 작성일
	private Date updateDate; //게시물 수정일
}
