package com.liuzheng.gem.image;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

public class ArrayToListTest {

	@SuppressWarnings("unchecked")
	@Test
	public void test() {

		List<String> imgExt = new ArrayList<String>();
		String imgExtStr = "jpg,gif,png,bmp";

		if (StringUtils.hasText(imgExtStr)) {
			String[] exts = imgExtStr.split(",");
			imgExt = CollectionUtils.arrayToList(exts);
			for (String ext : imgExt) {
				System.out.println(ext);
			}
		}
	}
}
