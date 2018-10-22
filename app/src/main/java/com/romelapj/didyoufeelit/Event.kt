package com.romelapj.didyoufeelit

data class Event
/**
 * Constructs a new [Event].
 *
 * @param eventTitle is the title of the earthquake event
 * @param eventNumOfPeople is the number of people who felt the earthquake and reported how
 * strong it was
 * @param eventPerceivedStrength is the perceived strength of the earthquake from the responses
 */
(
        /** Title of the earthquake event  */
        val title: String,
        /** Number of people who felt the earthquake and reported how strong it was  */
        val numOfPeople: String,
        /** Perceived strength of the earthquake from the people's responses  */
        val perceivedStrength: String
)