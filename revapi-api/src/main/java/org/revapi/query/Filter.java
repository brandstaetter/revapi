/*
 * Copyright 2014 Lukas Krejci
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
 * limitations under the License
 */

package org.revapi.query;

/**
 * A basic filter designed to work with element {@link org.revapi.Tree trees}.
 *
 * @author Lukas Krejci
 * @since 0.1
 */
public interface Filter<T> {

    /**
     * If an element in a tree is of compatible type, does the filter apply to it?
     *
     * @param element the element in the tree
     *
     * @return true if the filter applies, false otherwise
     */
    boolean applies(T element);

    /**
     * Should the tree traversal descend into the provided element? It is not guaranteed that the element is
     * of the type required by this parameter, but its children might be.
     * <p/>
     * Therefore the filter is given a chance to influence the decision even for elements of types that it is not
     * declared to filter.
     *
     * @param element the element to be descended into
     *
     * @return true if tree traversal should descend into the element, false otherwise
     */
    boolean shouldDescendInto(Object element);
}
