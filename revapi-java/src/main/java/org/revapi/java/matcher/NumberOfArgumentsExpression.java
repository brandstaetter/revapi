/*
 * Copyright 2015-2017 Lukas Krejci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 *
 */

package org.revapi.java.matcher;

import javax.lang.model.element.ExecutableElement;

import org.revapi.FilterMatch;
import org.revapi.java.spi.JavaAnnotationElement;
import org.revapi.java.spi.JavaMethodElement;
import org.revapi.java.spi.JavaModelElement;

/**
 * @author Lukas Krejci
 */
final class NumberOfArgumentsExpression implements MatchExpression {
    private final ComparisonOperator operator;
    private final int expected;

    NumberOfArgumentsExpression(ComparisonOperator operator, int expected) {
        this.operator = operator;
        this.expected = expected;
    }

    @Override
    public FilterMatch matches(JavaModelElement element) {
        if (!(element instanceof JavaMethodElement)) {
            return FilterMatch.DOESNT_MATCH;
        }

        ExecutableElement method = ((JavaMethodElement) element).getDeclaringElement();

        int nofArguments = method.getParameters().size();

        return FilterMatch.fromBoolean(operator.evaluate(nofArguments, expected));
    }

    @Override
    public FilterMatch matches(JavaAnnotationElement annotation) {
        return FilterMatch.DOESNT_MATCH;
    }

    @Override
    public FilterMatch matches(AnnotationAttributeElement attribute) {
        return FilterMatch.DOESNT_MATCH;
    }

    @Override
    public FilterMatch matches(TypeParameterElement typeParameter) {
        return FilterMatch.DOESNT_MATCH;
    }
}