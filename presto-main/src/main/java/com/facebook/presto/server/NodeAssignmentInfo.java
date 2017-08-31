/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.facebook.presto.server;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.concurrent.Immutable;

import static com.google.common.base.MoreObjects.toStringHelper;

@Immutable
public class NodeAssignmentInfo
{
    private final String nodeHost;
    private final int nodePort;
    private final int totalSplitCount;
    private final int numTasks;
    private final String state;

    @JsonCreator
    public NodeAssignmentInfo(
            @JsonProperty("nodeHost") String nodeHost,
            @JsonProperty("nodePort") int nodePort,
            @JsonProperty("totalSplitCount") int totalSplitCount,
            @JsonProperty("numTasks") int numTasks,
            @JsonProperty("state") String state)
    {
        this.nodeHost = nodeHost;
        this.nodePort = nodePort;
        this.totalSplitCount = totalSplitCount;
        this.numTasks = numTasks;
        this.state = state;
    }

    @JsonProperty
    public int getTotalSplitCount()
    {
        return totalSplitCount;
    }

    @JsonProperty
    public int getNumTasks()
    {
        return numTasks;
    }

    @JsonProperty
    public String getNodeHost()
    {
        return nodeHost;
    }

    @JsonProperty
    public int getNodePort()
    {
        return nodePort;
    }

    @JsonProperty
    public String getState()
    {
        return state;
    }

    @Override
    public String toString()
    {
        return toStringHelper(this)
                .add("nodeHost", nodeHost)
                .add("nodePort", nodePort)
                .add("totalSplitCount", totalSplitCount)
                .add("numTasks", numTasks)
                .add("state", state)
                .toString();
    }
}
