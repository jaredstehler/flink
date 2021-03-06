/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.runtime.rest.handler.legacy;

import org.apache.flink.runtime.executiongraph.AccessExecutionVertex;
import org.apache.flink.runtime.rest.handler.legacy.metrics.MetricFetcher;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

/**
 * Request handler providing details about a single task execution attempt.
 */
public class SubtaskCurrentAttemptDetailsHandler extends SubtaskExecutionAttemptDetailsHandler {

	public static final String SUBTASK_CURRENT_ATTEMPT_DETAILS_REST_PATH = "/jobs/:jobid/vertices/:vertexid/subtasks/:subtasknum";

	public SubtaskCurrentAttemptDetailsHandler(ExecutionGraphCache executionGraphHolder, Executor executor, MetricFetcher fetcher) {
		super(executionGraphHolder, executor, fetcher);
	}

	@Override
	public String[] getPaths() {
		return new String[]{SUBTASK_CURRENT_ATTEMPT_DETAILS_REST_PATH};
	}

	@Override
	public CompletableFuture<String> handleRequest(AccessExecutionVertex vertex, Map<String, String> params) {
		return handleRequest(vertex.getCurrentExecutionAttempt(), params);
	}
}
