package net.adoptopenjdk.icedteaweb.userdecision;

import net.adoptopenjdk.icedteaweb.client.parts.dialogs.security.remember.Remember;
import net.sourceforge.jnlp.JNLPFile;

import java.util.Optional;

public interface UserDecisions {
    <T extends Enum<T>> Optional<T> getUserDecisions(UserDecision.Key key, JNLPFile file, Class<T> resultType);

    <T extends Enum<T>> void saveForDomain(JNLPFile file, UserDecision<T> userDecision);

    <T extends Enum<T>> void saveForApplication(JNLPFile file, UserDecision<T> userDecision);

    default <T extends Enum<T>> void save(Remember result, JNLPFile file, UserDecision<T> userDecision) {
        if (result == Remember.REMEMBER_BY_DOMAIN) {
            saveForDomain(file, userDecision);
        }
        else if (result == Remember.REMEMBER_BY_APPLICATION) {
            saveForApplication(file, userDecision);
        }
    }
}
