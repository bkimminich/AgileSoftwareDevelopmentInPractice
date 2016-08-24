package de.kimminich.agile.examples.lecture3.optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class RateCalculator {

    private static Map<String, Integer> rates = new HashMap<>();

    public Integer calculateRateTo(String country) throws NoRateAvailableException {
        return rateTo(country).orElseThrow(NoRateAvailableException::new);
    }

    public Integer calculateRateTo(String country, int defaultRate) {
        return rateTo(country).orElse(defaultRate);
    }

    public Integer calculateRateTo(String country, Supplier<Integer> alternativeRate) {
        return rateTo(country).orElseGet(alternativeRate);
    }

    private Optional<Integer> rateTo(String country) {
        return Optional.ofNullable(rates.get(country));
    }

    private final class NoRateAvailableException extends Exception {
    }

}