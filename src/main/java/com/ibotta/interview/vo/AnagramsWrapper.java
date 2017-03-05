package com.ibotta.interview.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nsandford on 3/4/17 at 10:17 PM
 */
public class AnagramsWrapper
{
   private List<String> anagrams = new ArrayList<>();

   public AnagramsWrapper()
   {

   }

   public AnagramsWrapper(List<String> anagrams)
   {
      this.anagrams = anagrams;
   }

   public List<String> getAnagrams()
   {
      return anagrams;
   }

   public void setAnagrams(List<String> anagrams)
   {
      this.anagrams = anagrams;
   }
}
