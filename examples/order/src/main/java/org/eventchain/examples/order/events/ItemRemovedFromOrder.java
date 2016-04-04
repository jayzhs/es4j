/**
 * Copyright 2016 Eventchain team
 *
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
 */
package org.eventchain.examples.order.events;

import com.googlecode.cqengine.query.option.QueryOptions;
import lombok.*;
import lombok.experimental.Accessors;
import org.eventchain.Event;
import org.eventchain.annotations.Index;
import org.eventchain.index.SimpleAttribute;

import java.util.UUID;

import static org.eventchain.index.IndexEngine.IndexFeature.EQ;

@RequiredArgsConstructor
@NoArgsConstructor
@Accessors(fluent = true)
public class ItemRemovedFromOrder extends Event {
    @Getter @Setter @NonNull
    private UUID itemId;

    @Index({EQ})
    public static final SimpleAttribute<ItemRemovedFromOrder, UUID> LINE_ID = new SimpleAttribute<ItemRemovedFromOrder, UUID>("itemId") {
        public UUID getValue(ItemRemovedFromOrder itemRemovedFromOrder, QueryOptions queryOptions) {
            return itemRemovedFromOrder.itemId();
        }
    };

}
