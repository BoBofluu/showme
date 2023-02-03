package showme.openAi;


import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * EntityClass
 */
@Data
@AllArgsConstructor
public class OpenAi {
    String id;
    String name;
    String desc;
    String model;
    // PromptTemplate
    String prompt;
    // InnovativeSampling
    Double temperature;
    // EmotionSampling
    Double topP;
    // NumberOfResults
    Double n = 1d;
    // FrequencyPenaltyFactor
    Double frequencyPenalty;
    // RepeatPenaltyFactor
    Double presencePenalty;
    // stopWords
    String stop;
}
