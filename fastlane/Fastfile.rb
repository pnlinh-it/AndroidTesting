# This file contains the fastlane.tools configuration
# You can find the documentation at https://docs.fastlane.tools
#
# For a list of all available actions, check out
#
#     https://docs.fastlane.tools/actions
#
# For a list of all available plugins, check out
#
#     https://docs.fastlane.tools/plugins/available-plugins
#

# Uncomment the line if you want fastlane to automatically update itself
# update_fastlane

default_platform(:android)

platform :android do
  desc "Runs all the tests"
  lane :test do
    gradle(task: "test")
  end

  desc "Submit a new Beta Build to Crashlytics Beta"
  lane :beta do
    gradle(task: "assembleDebug")


    upload_to_slack()

      #crashlytics
  
    # sh "your_script.sh"
    # You can also use other beta testing services here
  end

  desc "Deploy a new version to the Google Play"
  lane :deploy do
    gradle(task: "clean assembleRelease")
    upload_to_play_store
  end

  # Add this to your Fastfile
  desc "Upload the APK to Slack channel"
  private_lane :upload_to_slack do |options|
    #file_path = lane_context[SharedValues::GRADLE_ALL_APK_OUTPUT_PATHS]
    #puts(file_path)
    #file_name = file_path.gsub(/\/.*\//,"")
    #sh "echo Uploading " + file_name + " to Slack"
    #sh "curl https://slack.com/api/files.upload -F token=\"token\" -F channels=\"#channel\" -F title=\"" + file_name + "\" -F filename=\"" + file_name + "\" -F file=@" + file_path
  end
end
