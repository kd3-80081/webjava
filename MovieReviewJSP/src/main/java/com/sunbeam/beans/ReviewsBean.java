package com.sunbeam.beans;

import java.util.List;

import com.sunbeam.dao.ReviewDao;
import com.sunbeam.dao.ReviewDaoImpl;

import com.sunbeam.pojos.Review;
import com.sunbeam.pojos.User;

public class ReviewsBean {

	private List<Review> list;

	public ReviewsBean() {

	}

	public List<Review> getList() {
		return list;
	}

	public void setList(List<Review> list) {
		this.list = list;
	}

	public void reviews() {
		try (ReviewDao rDao = new ReviewDaoImpl()) {
			list = rDao.findAll();
		}

		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
