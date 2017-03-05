package com.ibotta.interview.service;

import com.ibotta.interview.vo.AnagramsWrapper;

import java.util.List;

/**
 * Created by nsandford on 3/4/17 at 9:10 PM
 */
public interface AnagramService
{
   AnagramsWrapper searchForAnagrams(String word, Integer maxResults, boolean includeProperNouns);
   List<String> retrieveAllWords();
   void addWordsToDictionary(List<String> words);
   void deleteWordFromDictionary(String word);
   void deleteAllWords();
   int deleteAllAnagrams(String anagram);
}
