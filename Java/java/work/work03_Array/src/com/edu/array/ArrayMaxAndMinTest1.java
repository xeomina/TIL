package com.edu.array;

public class ArrayMaxAndMinTest1 {

	public static void main(String[] args) {
		int[] scores = {79,88,91,44,100,55,95};
		
		//scores 안에 들어있는 점수 중에서 가장 잘한 성적과 가장 못받은 성적을 찾아서 출력
		//가장 잘한 성적 -> MAX | 가장 못한 성적 -> MIN
		
		int min = scores[0]; //초기화시 가장 첫번째를 기준으로 삼는 것이 좋다. 
		int max = scores[0];
		
		//for문과 if문을 사용해서 로직을 작성.
		for(int i=0; i< scores.length; i++) {
			if(scores[i] < min)min =scores[i];
			if(scores[i] > max)max =scores[i];
		}
		System.out.println("최댓값: "+max);
		System.out.println("최솟값: "+min);
	}
}