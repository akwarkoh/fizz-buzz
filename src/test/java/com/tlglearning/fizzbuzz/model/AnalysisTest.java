package com.tlglearning.fizzbuzz.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EnumSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

class AnalysisTest {


  static final Set<State> neitherExpected=EnumSet.noneOf(State.class);
  final Analysis analysis= new Analysis();
  @ParameterizedTest
  @ValueSource(ints = {3, 21, 999_999_999, })
  void analyze_fizz(int value) {
    Set<State> expected = EnumSet.of(State.FIZZ);
    Analysis analysis = new Analysis();
    assertEquals(expected, analysis.analyze(value));

  }

  @ParameterizedTest
  @ValueSource(ints = {0,15 })
  void analyze_fizzBuzz(int value) {
    Set<State> expected = EnumSet.of(State.FIZZ, State.BUZZ);
    Analysis analysis = new Analysis();
    assertEquals(expected, analysis.analyze(value));

  }

  @ParameterizedTest
  @ValueSource(ints = {5,35, 55,50, })
  void analyze_buzz(int value) {
    Set<State> expected = EnumSet.of(State.BUZZ);
    Analysis analysis = new Analysis();
    assertEquals(expected, analysis.analyze(value));

  }
  @ParameterizedTest
  @CsvFileSource(resources="neither.Csv", numLinesToSkip=1)
  void analyze_neither(int value) {

    assertEquals(neitherExpected, analysis.analyze(value));

  }
  @ParameterizedTest
  @ValueSource(ints = {-1, -3, -5, -15})
  void analyze_negative(int value) {
    try {

    } catch (IllegalArgumentException e) {
      // Do nothing; this is the expected behavior.
    }

    }


    }