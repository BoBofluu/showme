package showme.controllers;


import com.theokanning.openai.completion.CompletionChoice;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSet;
import org.springframework.web.bind.annotation.*;
import showme.models.entites.AccountTypeCus;
import showme.openAi.OpenAiUtils;
import showme.services.EntityManagerService;
import showme.services.serviceImpl.BaseAppDAOImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/showme")
public class ExampleController {


    @Autowired
    private EntityManagerService entityManagerService;

    @Autowired
    private BaseAppDAOImpl baseAppDAOImpl;


    /**
     * 範例程式新增
     */
    @PostMapping("/testInsert")
    public void testInsert() {
        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO account_type_cus (userid, orderseq, typecolor, typename) VALUES (?,?,?,?)");
        HashMap<Integer, Object> hashMap = new HashMap<>();
        hashMap.put(1, 1);
        hashMap.put(2, 1);
        hashMap.put(3, 1);
        hashMap.put(4, 1);
        entityManagerService.insert(builder, hashMap);

    }

    /**
     * 範例程式查詢
     */
    @GetMapping("/testQuery")
    public void testQuery() {

        List<AccountTypeCus> data = entityManagerService.getAccountTypeCusAllData();
        System.out.println(data.get(0).getUserId());
    }

    /**
     * 範例程式查詢
     */
    @GetMapping("/testQuery2")
    public void testQueryAndParamter() throws Exception {

        List<AccountTypeCus> data = entityManagerService.getAccountTypeCusData();
        System.out.println(data.get(0).getUserId());


    }


    /**
     * testOpenAi
     */
    @PostMapping("/testOpenAi")
    public String testOpenAi(@RequestBody Map<String, String> map) throws Exception {
        String answerStr = null;
        List<CompletionChoice> answer;
        long start = System.currentTimeMillis();
        String model = map.get("model");
        String question = map.get("question");
        System.out.printf("chooseModel: %s \n starting...\n question: %s \n", model, question);
        switch (model) {
            case "Question":
                answer = OpenAiUtils.getQuestionAnswer(question);
                answerStr = answer.get(0).getText().replaceAll("\\r\\n", " ");
                break;
            case "Conversation":
                answer = OpenAiUtils.getFriendChat(question);
                answerStr = answer.get(0).getText().replaceAll("\\r\\n", " ");
                break;
            case "CreatStory":
                answer = OpenAiUtils.getStory(question);
                answerStr = answer.get(0).getText().replaceAll("\\r\\n", " ");
                break;
            case "WhiteEyeChat":
                answer = OpenAiUtils.getMarvChatbot(question);
                answerStr = answer.get(0).getText().replaceAll("\\r\\n", " ");
                break;
            default:
                System.out.println(" ");
        }

        if (!StringUtils.isEmpty(answerStr)) System.out.printf("answer: %s", answerStr);


        long end = System.currentTimeMillis();
        System.out.printf("\n 總共花了： %s 秒", (end - start) / 1000 + "\n");
        return answerStr;
    }
}
