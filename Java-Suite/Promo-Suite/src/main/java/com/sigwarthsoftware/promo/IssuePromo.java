package com.sigwarthsoftware.promo;


import com.sigwarthsoftware.promo.github.issue.Issue;
import com.sigwarthsoftware.promo.openai.Summarizer;
import com.sigwarthsoftware.promo.openai.prompt.IssuePrompts;
import com.sigwarthsoftware.twitter.publish.Publisher;

public class IssuePromo {
    public static void main(String[] args) {
        Issue issue = Issue.fromSystem();
        Summarizer summarizer = new Summarizer();
        String summary = summarizer.summarize(issue.toString(),
                                              IssuePrompts.SYSTEM.getText(),
                                              IssuePrompts.USER.getText());
        Publisher.publish(summary);
    }
}
