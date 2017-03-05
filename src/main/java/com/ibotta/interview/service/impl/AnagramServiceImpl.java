package com.ibotta.interview.service.impl;

import com.ibotta.interview.service.AnagramService;
import com.ibotta.interview.vo.AnagramsWrapper;
import com.ibotta.interview.vo.Word;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by nsandford on 3/4/17 at 9:10 PM
 */
@Service
public class AnagramServiceImpl implements AnagramService
{
   @Resource
   private Map<String, List<Word>> dictionary;

   @Override
   public AnagramsWrapper searchForAnagrams(String word)
   {
      List<Word> words = dictionary.get(Word.computeKey(word));

      return words == null ? new AnagramsWrapper() : new AnagramsWrapper(words.stream()
            .filter(w -> !w.getWord().equalsIgnoreCase(word))
            .map(Word::getWord)
            .collect(Collectors.toList()));
   }

   @Override
   public List<String> retrieveAllWords()
   {
      return dictionary.values().stream()
            .flatMap(List::stream)
            .map(Word::getWord)
            .sorted()
            .collect(Collectors.toList());
   }

   @Override
   public void addWordsToDictionary(List<String> words)
   {
      for (String word : words)
      {
         String key = Word.computeKey(word);
         List<Word> anagrams = dictionary.get(key);

         if (anagrams != null)
         {
            anagrams.add(new Word(word));
         }
         else
         {
            dictionary.put(key, new LinkedList<>(Collections.singletonList(new Word(word))));
         }
      }
   }

   @Override
   public void deleteWordFromDictionary(String word)
   {
      List<Word> words = dictionary.get(Word.computeKey(word));

      if (words != null)
      {
         Iterator<Word> iterator = words.iterator();

         while (iterator.hasNext())
         {
            Word temp = iterator.next();

            if (temp.getWord().equalsIgnoreCase(word))
            {
               iterator.remove();
               break;
            }
         }
      }
   }

   @Override
   public void deleteAllWords()
   {
      dictionary.clear();
   }
}
