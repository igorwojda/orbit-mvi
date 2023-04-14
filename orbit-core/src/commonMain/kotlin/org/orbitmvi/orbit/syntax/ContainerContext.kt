/*
 * Copyright 2021-2023 Mikołaj Leszczyński & Appmattus Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.orbitmvi.orbit.syntax

import org.orbitmvi.orbit.RealSettings
import org.orbitmvi.orbit.annotation.OrbitInternal
import org.orbitmvi.orbit.internal.repeatonsubscription.SubscribedCounter

@OrbitInternal
public class ContainerContext<S : Any, SE : Any>(
    public val settings: RealSettings,
    public val postSideEffect: suspend (intentName: String?, sideEffect: SE) -> Unit,
    private val getState: () -> S,
    public val reduce: suspend (intentName: String?, reducer: (S) -> S) -> Unit,
    public val subscribedCounter: SubscribedCounter
) {
    public val state: S
        get() = getState()
}
