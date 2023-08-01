package com.music.practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.music.practice.model.ChordConstruction;
import com.music.practice.model.FretboardFamiliarity;
import com.music.practice.model.PracticeProgram;
import com.music.practice.model.enums.Difficulty;

@RestController
public class PracticeController {

  private static PracticeProgram FRETBOARDFAMILIARITY = new FretboardFamiliarity();
  private static PracticeProgram CHORDCONSTRUCTION = new ChordConstruction();
 
  @GetMapping("/helloworld")
  public String helloWorld() {
    return "Hello, World!";
  }

  @GetMapping("/fretboardfamiliarity/{difficulty}")
  public String getNoteLocation(@PathVariable String difficulty) {
    return PracticeController.FRETBOARDFAMILIARITY.getPracticeCommand(Difficulty.valueOf(difficulty.toUpperCase()));
  }

  @GetMapping("/chordconstruction/{difficulty}")
  public String getChordConstruction(@PathVariable String difficulty) {
    return PracticeController.CHORDCONSTRUCTION.getPracticeCommand(Difficulty.valueOf(difficulty.toUpperCase()));
  }



}
