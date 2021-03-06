package com.ibotta.interview.controller;

import com.ibotta.interview.service.AnagramService;
import com.ibotta.interview.vo.AnagramsWrapper;
import com.ibotta.interview.vo.WordWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
   public ResponseEntity<AnagramsWrapper> searchForAnagrams(@PathVariable("word") String word,
                                            @RequestParam(value = "limit", required = false) Integer maxResults,
                                            @RequestParam(value = "includeProperNouns", required = false, defaultValue = "true") boolean includeProperNouns)
   {
      if (maxResults != null && maxResults < 0)
      {
         return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }

      return ResponseEntity.ok().body(anagramService.searchForAnagrams(word, maxResults, includeProperNouns));
   }

   @RequestMapping(value = "/words.json", method = RequestMethod.GET)
   public List<String> retrieveAllWords()
   {
      return anagramService.retrieveAllWords();
   }

   @RequestMapping(value = "/words", method = RequestMethod.POST)
   public ResponseEntity addWordsToDictionary(@RequestBody @Valid WordWrapper wrapper)
   {
      anagramService.addWordsToDictionary(wrapper.getWords());

      return new ResponseEntity(HttpStatus.CREATED);
   }

   @RequestMapping(value = "/words/{word}", method = RequestMethod.DELETE)
   public void deleteWord(@PathVariable("word") String word)
   {
      anagramService.deleteWordFromDictionary(word);
   }

   @RequestMapping(value = "/words", method = RequestMethod.DELETE)
   public ResponseEntity deleteAllWords()
   {
      anagramService.deleteAllWords();

      return new ResponseEntity(HttpStatus.NO_CONTENT);
   }

   @RequestMapping(value = "/anagrams/{anagram}", method = RequestMethod.DELETE)
   public ResponseEntity<Integer> deleteAllAnagrams(@PathVariable("anagram") String anagram)
   {
      return ResponseEntity.ok().body(anagramService.deleteAllAnagrams(anagram));
   }
}
