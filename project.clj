(require 'cemerick.pomegranate.aether)
(cemerick.pomegranate.aether/register-wagon-factory!
  "http" #(org.apache.maven.wagon.providers.http.HttpWagon.))

(defproject factual/drake "1.0.3-tres-SNAPSHOT"
  :description "Drake: the data processing workflow tool (a.k.a. 'make for data')"
  :url "https://github.com/Factual/drake"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :scm {:name "git"
        :url "https://github.com/Factual/drake"}
  :repositories [["libs-snapshot" "http://server02.tresata.com:8081/artifactory/libs-snapshot"] ["libs-release" "http://server02.tresata.com:8081/artifactory/libs-release"]]
  :deploy-repositories [["snapshots" "http://server02.tresata.com:8081/artifactory/oss-libs-snapshot-local"] ["releases" "http://server02.tresata.com:8081/artifactory/oss-libs-release-local"]]
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/core.memoize "0.5.6"]
                 [factual/drake-interface "0.0.1"]
                 [org.clojure/tools.logging "0.2.3"]
                 [clj-logging-config "1.9.6"]
                 [clojopts/clojopts "0.3.4"]
                 [org.flatland/useful "0.11.3"]
                 [fs "1.3.2"]
                 [factual/jlk-time "0.1"]
                 [clj-time "0.6.0"]
                 [digest "1.4.0"]
                 [com.google.guava/guava "14.0.1"]
                 [cheshire "5.2.0"]
                 [rhizome "0.2.5"]
                 [slingshot "0.10.3"]
                 [factual/fnparse "2.3.0"]
                 [commons-codec/commons-codec "1.6"]
                 [factual/sosueme "0.0.15"]
                 [factual/c4 "0.2.1"]
                 [hdfs-clj "0.1.3"]    ;; for HDFS support
                 [org.apache.hadoop/hadoop-core "0.20.2"]
                 [clj-aws-s3 "0.3.10-tres-SNAPSHOT" :exclusions [joda-time]]    ;; for AWS S3 support
                 ;; for plugins
                 [com.cemerick/pomegranate "0.2.0" :exclusions [org.apache.httpcomponents/httpcore]]]
  :test-selectors {:regression   :regression
                   :default      (complement :regression)
                   :all          (constantly true)}
  :main drake.core
  :uberjar-name "drake.jar"
  :aot :all)
