package project.ability;

import java.time.LocalDate;

public class HumaneAbility {
    public ZodiacSign getZodiacSign(int year, int month, int day) {
        LocalDate birthDate = LocalDate.of(year, month, day);
        if (birthDate.isBefore(LocalDate.of(year, 1, 20))) return ZodiacSign.Capricornus;
        if (birthDate.isBefore(LocalDate.of(year, 2, 20))) return ZodiacSign.Aquarius;
        if (birthDate.isBefore(LocalDate.of(year, 3, 20))) return ZodiacSign.Pisces;
        if (birthDate.isBefore(LocalDate.of(year, 4, 20))) return ZodiacSign.Aries;
        if (birthDate.isBefore(LocalDate.of(year, 5, 21))) return ZodiacSign.Taurus;
        if (birthDate.isBefore(LocalDate.of(year, 6, 21))) return ZodiacSign.Gemini;
        if (birthDate.isBefore(LocalDate.of(year, 7, 22))) return ZodiacSign.Cancer;
        if (birthDate.isBefore(LocalDate.of(year, 8, 22))) return ZodiacSign.Leo;
        if (birthDate.isBefore(LocalDate.of(year, 9, 22))) return ZodiacSign.Virgo;
        if (birthDate.isBefore(LocalDate.of(year, 10, 23))) return ZodiacSign.Libra;
        if (birthDate.isBefore(LocalDate.of(year, 11, 22))) return ZodiacSign.Scorpius;
        if (birthDate.isBefore(LocalDate.of(year, 12, 22))) return ZodiacSign.Sagittarius;
        return ZodiacSign.Capricornus;
    }

}
