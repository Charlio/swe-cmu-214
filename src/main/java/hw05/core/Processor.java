package hw05.core;

import java.util.List;

abstract class Processor {
    abstract DataSet apply(List<DataSet> sources);
}
