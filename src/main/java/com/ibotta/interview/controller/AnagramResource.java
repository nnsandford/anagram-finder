package com.ibotta.interview.controller;

import com.ibotta.interview.service.AnagramService;
import com.ibotta.interview.vo.AnagramsWrapper;
import com.ibotta.interview.vo.WordWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by nsandford on 3/4/17 at 4:41 PM
 */
@RestController
public class AnagramResource
{
   @Autowired
   private AnagramService anagramService;

   @RequestMapping(value = "/anagrams/{word}", method = RequestMethod.GET)
   public AnagramsWrapper searchForAnagrams(@PathVariable("word") String word,
                                            @RequestParam(value = "maxResults", required = false) Integer maxResults,
                                            @RequestParam(value = "includeProperNouns", required = false, defaultValue = "true") boolean includeProperNouns)
   {
      return anagramService.searchForAnagrams(word, maxResults, includeProperNouns);
   }

   @RequestMapping(value = "/words", method = RequestMethod.GET)
   public List<String> retrieveAllWords()
   {
      return anagramService.retrieveAllWords();
   }

   @RequestMapping(value = "/words", method = RequestMethod.POST)
   public void addWordsToDictionary(@RequestBody WordWrapper wrapper)
   {
      anagramService.addWordsToDictionary(wrapper.getWords());
   }

   @RequestMapping(value = "/words/{word}", method = RequestMethod.DELETE)
   public void deleteWord(@PathVariable("word") String word)
   {
      anagramService.deleteWordFromDictionary(word);
   }

   @RequestMapping(value = "/words", method = RequestMethod.DELETE)
   public void deleteAllWords()
   {
      anagramService.deleteAllWords();
   }
}
