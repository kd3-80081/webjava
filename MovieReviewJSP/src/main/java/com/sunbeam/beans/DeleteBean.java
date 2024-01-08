package com.sunbeam.beans;

import com.sunbeam.dao.ReviewDao;
import com.sunbeam.dao.ReviewDaoImpl;
import com.sunbeam.pojos.User;

public class DeleteBean {

	private int reviewId;
	private int count;
	private String url;

	public DeleteBean() {

	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void delete() {
		System.out.println("URL :" + url +", | reviewId : " + reviewId);
		try (ReviewDao rDao = new ReviewDaoImpl()) {
			count = rDao.deleteById(reviewId);
			System.out.println("Count : " + count);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
