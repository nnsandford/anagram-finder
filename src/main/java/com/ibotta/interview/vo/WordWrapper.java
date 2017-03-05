package com.ibotta.interview.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by nsandford on 3/4/17 at 10:06 PM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WordWrapper
{
   @NotNull
   @Size(min = 1)
   private List<String> words;

   public List<String> getWords()
   {
      return words;
   }

   public void setWords(List<String> words)
   {
      this.words = words;
   }
}
