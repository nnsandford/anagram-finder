package com.ibotta.interview.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by nsandford on 3/4/17 at 5:19 PM
 */
@JsonIgnoreProperties({"key", "properNoun"})
public class Word
{
   private String word;
   private String key;
   private boolean properNoun;

   public Word(String word)
   {
      this.word = word;
      this.key = computeKey(word);
      this.properNoun = word != null && !word.isEmpty() && Character.isUpperCase(word.charAt(0));
   }

   public static String computeKey(String word)
   {
      return word == null ? "" : Stream.of(word.toLowerCase().split("")).sorted().collect(Collectors.joining());
   }

   public String getWord()
   {
      return word;
   }

   public String getKey()
   {
      return key;
   }
}
