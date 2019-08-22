/************************************************************
 *                                                          *
 *  CSCI 470     In class Assignment 1           Fall 2018  *                                             
 *                                                          *
 *  Programmer: Antony Pierson                              *  
 *                                                          *
 *  Date Due:   09/30/2018                                  *                          
 *                                                          *
 *  Purpose:    polling program that allows users to rate   *
 *              socal-consciousness issues from 1-10        *
 ************************************************************/ 
import java.util.ArrayList;
import java.util.Scanner;                
import java.io.IOException;
import java.io.*;  
import java.util.Collection;
import java.lang.String;

public class Polling  
{
  public static void main(String[] args)
  {
    String topics[] = new String[]{"Violence", "Poverty ", "Racism  ", "Sexism  ", "Drugs   "}; //array to hold issues
    int highlow[] = new int[5];               //array to hold highest points
    int responses[][] = new int[5][10];       //two dimensional array of 5 rows 10 columns
    int rating;                               //variable to hold rating
    int totalRatings = 0;                     //variable to hold total ratings
    int totalUsers = 0;                       //variable to hold total users
    char answer = 'Y';                        //variable to hold user response for another user         
    
    Scanner keyScan = new Scanner(System.in);      // scanner to get user input
    Scanner newAnswer = new Scanner( System.in );  // Scanner to get check if another users response

    //Loop for displaying questions, issues and get users responses
    do
    {
      totalUsers += 1;              //add 1 to total users each pass
     
      System.out.print("Rate each socal-consciousness issue from 1(least important) to 10(most important)\n");
      
      //Loop to display topic and get user response
      for (int i = 0; i < 5; i++)
      {
        System.out.print("\n" + topics[i]);   //print topics
        rating = keyScan.nextInt();           //get user rating input
        responses[i][rating - 1] +=1;         
      }  
      
      System.out.print("\nIs there another user? enter y (yes) or n (no): ");
      answer=newAnswer.next().charAt(0);    //get response for if another user 
    } 
    // The application will continue stop if 'n' is entered.
    while (answer != 'n');
   
    System.out.print("         1  2  3  4  5  6  7  8  9  10  Average");
    
    //loop to print topics and summary of results 
    for (int r = 0; r < 5; r++)
    {
      System.out.print("\n" + topics[r]);
      for(int n = 0; n < 10; n++)
      {
        totalRatings += responses[r][n] * (n + 1);   //add up the ratings for each topic
        
        System.out.printf(" " + responses[r][n] + " ");  //print summary
      }
      
      highlow[r] = totalRatings;
      double avg = totalRatings/totalUsers;   
      System.out.printf("  %3.2f", avg);      // print average
      totalRatings = 0;                       //clear total ratings
    }
    
    int high = highlow[0];
    int low = highlow[0];
    int highIssue = 0;
    int lowIssue = 0;
    
    //loop to get highest and lowest topics display both topic and total points
    for(int i = 1; i < 5; i++)
    {
      if (highlow[i] > high)
      {
        high = highlow[i];
        highIssue = i;
      }
      
           if (highlow[i] < low)
      {
        low = highlow[i];
        lowIssue = i;
      }
    } 
    
    System.out.printf("\n\nThe topic with the highest points is " + topics[highIssue] + " with " + high + " points\n");
    System.out.printf("The topic with the lowest points is " + topics[lowIssue] + " with " + low + " points\n");
    
    keyScan.close();
    newAnswer.close();
  }
}