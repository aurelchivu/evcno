/* Evcno (C)2024 */
package com.optimiser.evcno.read.application;

public interface DataHandler<T> extends BaseDataHandler {

    void handleData(T data);
}
