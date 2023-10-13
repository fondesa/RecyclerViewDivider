#!/bin/bash

scriptDir="$(cd "$(dirname "${BASH_SOURCE[0]}")" >/dev/null 2>&1 && pwd)"
projectDir=${scriptDir}/..

ROBOLECTRIC_MIN_API=16
ROBOLECTRIC_MAX_API=33

robolectricConfigFile=$projectDir/recycler-view-divider/src/test/resources/robolectric.properties
# Writes the API versions which should be used for Robolectric tests.
echo "minSdk=$ROBOLECTRIC_MIN_API" >"$robolectricConfigFile"
echo "maxSdk=$ROBOLECTRIC_MAX_API" >>"$robolectricConfigFile"
# Runs the tests with given API, passing additional params (e.g. the enabled SDKs).
"$projectDir"/gradlew :recycler-view-divider:testReleaseUnitTest -s "$@"
