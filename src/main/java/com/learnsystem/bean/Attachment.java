package com.learnsystem.bean;

/**
 * 课程附件（图片、视频等资料）
 */
public class Attachment {

	private Integer id;
	/**
	 * 附件文件名
	 */
    private String fileName;
	/**
	 * 所属课程章节id
	 */
	private int articleId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	@Override
	public String toString() {
		return "Attachment{" +
				"id=" + id +
				", fileName='" + fileName + '\'' +
				", articleId=" + articleId +
				'}';
	}
}