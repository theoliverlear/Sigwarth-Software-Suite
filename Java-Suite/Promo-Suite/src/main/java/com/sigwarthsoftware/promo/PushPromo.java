package com.sigwarthsoftware.promo;


import com.sigwarthsoftware.promo.github.commit.CommitCapture;
import com.sigwarthsoftware.promo.openai.Summarizer;
import com.sigwarthsoftware.promo.openai.prompt.PushPrompts;
import com.sigwarthsoftware.twitter.publish.Publisher;

public class PushPromo {
    //===============================-Main-===================================
    public static void main(String[] args) {
        CommitCapture capture = new CommitCapture();
        Summarizer summarizer = new Summarizer();
        String summary = summarizer.summarize(capture,
                                              PushPrompts.SYSTEM.getText(),
                                              PushPrompts.USER.getText());
        Publisher.publish(summary);
    }
}
