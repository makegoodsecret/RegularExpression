package rx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式
 * 
 * @param wxp
 */
public class RegularExpression {

	public static void p(Object object) {
		System.out.println(object.toString());
	}

	/**
	 * 匹配以某个字符串开头，任意字符串结尾的一个字符串
	 * 匹配规则^start.*
	 */
	public static void startWith() {
		boolean flag = false;
		Pattern pattern = Pattern.compile("^android.*");
		Matcher matcher = pattern.matcher("android hello");
		flag = matcher.matches();
		p(flag);
	}

	/**
	 * 以某个符号分割一串字符串
	 * 匹配规则[,|]
	 * 其中 , 可以换成别的符号
	 */
	public static void splitWith(){

		Pattern pattern=Pattern.compile("[,|]");
		String [] arrays=pattern.split("hello,android");
		p(arrays.length);
	}
	
	/**
	 * 替换首次出现的匹配的字符串
	 * 其中matcher的replaceFirst方法返回的是替换后的整个字符串
	 */
	public static void replaceFisrt(){
		Pattern pattern=Pattern.compile("hello");
		Matcher matcher=pattern.matcher("hello android");
		p(matcher.replaceFirst("i love"));
	}
	
	/**
	 * 替换所有匹配的字串
	 */
	public static void replaceAll(){
		Pattern pattern = Pattern.compile("正则表达式");
		Matcher matcher = pattern.matcher("正则表达式 Hello World,正则表达式 Hello World ");
		p(matcher.replaceAll("Java"));
	}
	
	/**
	 * 同上
	 */
	public static void replaceAllChar(){
		Pattern pattern = Pattern.compile("正则表达式");
		Matcher matcher = pattern.matcher("正则表达式 Hello World,正则表达式 Hello World ");
		StringBuffer sbr = new StringBuffer();
		while (matcher.find()) {
		    matcher.appendReplacement(sbr, "Java");
		}
		matcher.appendTail(sbr);
		System.out.println(sbr.toString());
	}
	public static void main(String[] args) {
		replaceAll();
		replaceAllChar();

	}

}
