package com.zhiyou.util;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		System.out.println("欢迎致电10086，人工服务请按1，登录请按2，退出请按3");
		int a = scanner.nextInt();
		switch (a) {
		case 1:
			System.out.println("欢迎致电中国移动。我是一号人工客服，请问有什么需要帮助的吗？");
			break;
		case 2:

			System.out.println("请输入登录密码：");
			int b = scanner.nextInt();
			if (b == 123456) {
				System.out.println("欢迎您！");

			} else {
				System.out.println("密码输入错误！请重新登录");
				break;
			}
			break;
		case 3:

			break;

		default:
			break;
		}

	}

}
