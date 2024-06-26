// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.implementation;

import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.dev.fluent.PreviewsClient;
import com.azure.dev.fluent.models.PreviewRunInner;
import com.azure.dev.models.PreviewRun;
import com.azure.dev.models.Previews;
import com.azure.dev.models.RunPipelineParameters;

public final class PreviewsImpl implements Previews {
    private static final ClientLogger LOGGER = new ClientLogger(PreviewsImpl.class);

    private final PreviewsClient innerClient;

    private final com.azure.dev.DevManager serviceManager;

    public PreviewsImpl(PreviewsClient innerClient, com.azure.dev.DevManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public Response<PreviewRun> previewWithResponse(String organization, String project, int pipelineId,
        RunPipelineParameters body, Integer pipelineVersion, Context context) {
        Response<PreviewRunInner> inner = this.serviceClient()
            .previewWithResponse(organization, project, pipelineId, body, pipelineVersion, context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new PreviewRunImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public PreviewRun preview(String organization, String project, int pipelineId, RunPipelineParameters body) {
        PreviewRunInner inner = this.serviceClient().preview(organization, project, pipelineId, body);
        if (inner != null) {
            return new PreviewRunImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    private PreviewsClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.dev.DevManager manager() {
        return this.serviceManager;
    }
}