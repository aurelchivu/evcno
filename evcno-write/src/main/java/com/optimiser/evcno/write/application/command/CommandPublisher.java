package com.optimiser.evcno.write.application.command;

public interface CommandPublisher {

    <T> void publishCommand(final T aDomainCommand);
}
