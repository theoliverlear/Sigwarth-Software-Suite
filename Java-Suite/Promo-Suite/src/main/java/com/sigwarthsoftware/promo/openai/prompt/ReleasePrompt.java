package com.sigwarthsoftware.promo.openai.prompt;

public enum ReleasePrompt {
    SYSTEM("""
            You are crafting ONE tweet to announce a new %s release. This is a user-facing announcement.
            Your job is to be SPECIFIC and USER-FACING.
            - Explicitly name 2–4 concrete things users can now do or will notice.
            - Prefer features over vague themes. Use the names of features, not files.
            - Mention the version once in a natural way (e.g., "v1.2.3 is out").
            - If modules are mentioned (Website, Desktop, API, Testing, etc.), call them out plainly.
            - Ignore internal chores (refactors, build, deps) unless they change user behavior; if none, focus on stability/perf with specifics.
            - No low-level paths or issue IDs. No links. No quotes.
            - Keep it upbeat but not salesy. Max ONE short hashtag only if obvious.
            - Fit comfortably in a single tweet; prefer concise separators like •, |, or commas.
            """.formatted(System.getenv("APP_NAME"))),
    USER("""
            You will receive a version name and a large CHANGELOG. Produce one concise tweet that:
            - Starts with the product and version once.
            - Lists 2–4 specific, user-visible changes using concrete nouns and verbs (what, where, benefit).
            - Prioritizes by impact to end users; de-duplicate similar items; skip internal-only changes.
            - If only fixes/perf are present, specify scope (e.g., "crash on login fixed", "startup ~30% faster").
            - Avoid filler like "improvements" without details; name the feature or area.
            - No links, no quotes, at most one short hashtag if it truly adds value.
            Release details:\n""");

    private final String text;

    ReleasePrompt(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
