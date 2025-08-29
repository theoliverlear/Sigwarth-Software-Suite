package com.sigwarthsoftware.promo;


import com.sigwarthsoftware.promo.github.release.Release;
import com.sigwarthsoftware.promo.openai.Summarizer;
import com.sigwarthsoftware.promo.openai.prompt.ReleasePrompt;
import com.sigwarthsoftware.twitter.publish.Publisher;

public class ReleasePromo {
    public static void main(String[] args) {
        Release release = Release.fromSystem();
        Summarizer summarizer = new Summarizer();
        String summary = summarizer.summarize(release.toString(),
                                              ReleasePrompt.SYSTEM.getText(),
                                              ReleasePrompt.USER.getText());
        Publisher.publish(summary);
    }
}