package com.lft;

import org.junit.jupiter.api.Test;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

class Pin {

	@Test
	void test() throws BadHanyuPinyinOutputFormatCombination {
		 HanyuPinyinOutputFormat pyFormat = new        HanyuPinyinOutputFormat();
		          pyFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		         pyFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		         pyFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
		 
		    String aa=PinyinHelper.toHanyuPinyinString("我爱中你你你国", pyFormat, "");
		    
		    System.out.println(aa);
	}

}
